from knox import views as knox_views
from django.urls import path
from . import views

urlpatterns = [
    path('',views.apiOverview, name='apiOverview'),
    path('api/list/', views.ShowAll, name='list'),  # 'GET' api to list all the address updates
    path('api/update/', views.UpdateAddress, name='update'),  # 'POST' api to update address
    path('api/register/', views.RegisterAPI.as_view(), name='register'),
    path('api/login/', views.LoginAPI.as_view(), name='login'),
    path('api/logout/', knox_views.LogoutView.as_view(), name='logout'),
    path('api/logoutall/', knox_views.LogoutAllView.as_view(), name='logoutall'),
    path('api/user/', views.UserAPI.as_view(), name='user'),
    path('upload/', views.ImageViewSet.as_view(), name='upload'),
]