from django.db import models

# Create your models here.

def nameFile(instance, filename):
    return '/'.join(['images', str(instance.name), filename])

#models for address
class Address(models.Model):
    aadhaar_number = models.CharField(max_length=16)
    house_building_apartment = models.CharField(max_length=180)
    street_road_lane = models.CharField(max_length=250)
    area_locality_sector = models.CharField(max_length=250)
    landmark = models.CharField(max_length=250)
    village_town_city = models.CharField(max_length=250)
    pincode = models.CharField(max_length=6)
    subdistrict = models.CharField(max_length=250)
    district = models.CharField(max_length=250)
    state = models.CharField(max_length=250)
    image = models.ImageField(upload_to='s_doc', blank=True, null=True)
    time = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.aadhaar_number

class UploadImageTest(models.Model):
    name = models.CharField(max_length=100)
    image = models.ImageField(upload_to=nameFile, blank=True, null=True)