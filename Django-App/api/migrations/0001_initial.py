# Generated by Django 3.2.8 on 2021-10-28 19:35

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Address',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('aadhaar_number', models.IntegerField(max_length=16)),
                ('house_building_apartment', models.CharField(max_length=180)),
                ('street_road_lane', models.CharField(max_length=250)),
                ('area_locality_sector', models.CharField(max_length=250)),
                ('landmark', models.CharField(max_length=250)),
                ('village_town_city', models.CharField(max_length=250)),
                ('pincode', models.CharField(max_length=6)),
                ('subdistrict', models.CharField(max_length=250)),
                ('district', models.CharField(max_length=250)),
                ('state', models.CharField(max_length=250)),
                ('time', models.DateTimeField(auto_now=True)),
            ],
        ),
    ]
