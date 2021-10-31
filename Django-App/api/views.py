from django.shortcuts import render
from rest_framework.response import Response
from django.http import HttpResponse
from rest_framework.decorators import api_view
from .serializers import AddressSerializer, ImageSerializer
from .models import Address, UploadImageTest
import json

# Create your views here.


@api_view(['GET'])
def apiOverview(request):
    api_urls = {
        'update': '/address-update/'

    }
    return Response(api_urls)


@api_view(['GET'])
def ShowAll(request):
    address = Address.objects.all()
    serializer = AddressSerializer(address, many=True)
    return Response(serializer.data)


####### UPDATE ADDRESS ######
@api_view(['POST'])
def UpdateAddress(request):
    serializer = AddressSerializer(data=request.data)

    if serializer.is_valid():
        serializer.save()
    return Response(serializer.data)


from rest_framework import generics, permissions
from rest_framework.response import Response
from knox.models import AuthToken
from .serializers import UserSerializer, RegisterSerializer


# Register API
class RegisterAPI(generics.GenericAPIView):
    serializer_class = RegisterSerializer

    def post(self, request, *args, **kwargs):
        serializer = self.get_serializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.save()
        return Response({
            "user": UserSerializer(user, context=self.get_serializer_context()).data,
            "token": AuthToken.objects.create(user)[1]
        })

from django.contrib.auth import login

from rest_framework import permissions
from rest_framework.authtoken.serializers import AuthTokenSerializer
from knox.views import LoginView as KnoxLoginView

class LoginAPI(KnoxLoginView):
    permission_classes = (permissions.AllowAny,)

    def post(self, request, format=None):
        serializer = AuthTokenSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.validated_data['user']
        login(request, user)
        return super(LoginAPI, self).post(request, format=None)


# Get User API
class UserAPI(generics.RetrieveAPIView):
    permission_classes = [permissions.IsAuthenticated,]
    serializer_class = UserSerializer

    def get_object(self):
        return self.request.user



# class ImageViewSet(generics.ListAPIView):
#     queryset = Address.objects.all()
#     serializer_class = ImageSerializer
#
#     def post(self, request, *args, **kwargs):
#         file = request.data['file']
#         image = Address.objects.create(image=file)
#         return HttpResponse(json.dumps({'message': "Uploaded"}), status=200)

class ImageViewSet(generics.ListAPIView):
    queryset = UploadImageTest.objects.all()
    serializer_class = ImageSerializer

    def post(self, request, *args, **kwargs):
        file = request.data['file']
        image = UploadImageTest.objects.create(image=file)
        return HttpResponse(json.dumps({'message': "Uploaded"}), status=200)