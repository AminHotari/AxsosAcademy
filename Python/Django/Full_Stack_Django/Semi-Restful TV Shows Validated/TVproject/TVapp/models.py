from django.db import models
import datetime

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) < 2:
            errors["title"] = "Title should be at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "Network should be at least 3 characters"
        if len(postData['desc']) < 10 and len(postData['desc']) != 0:
            errors["desc"] = "Description should be at least 10 characters 0r 0"
        if postData['relasedate'] > str(datetime.date.today()):
            errors["relasedate"] = "Relasedate should be in the past"
        return errors

class Show(models.Model):
    title = models.CharField(max_length=45)
    network = models.CharField(max_length=45)
    release_date = models.DateField()
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()
