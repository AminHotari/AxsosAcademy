from turtle import title
from venv import create
from django.db import models
import re

class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "First name should be at least 2 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "Last name should be at least 2 characters"
        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters"
        if postData['password'] != postData['confirm']:
            errors["password"] = "Password should match with confirm password"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):
            errors['email'] = "Invalid email address!"
        return errors

class User(models.Model):
    first_name = models.CharField(max_length = 45)
    last_name = models.CharField(max_length = 45)
    email = models.CharField(max_length = 45)
    password = models.CharField(max_length = 255)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = UserManager()


class BookManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if postData['title'] == "":
            errors["title"] = "Title is required"
        if len(postData['desc']) < 5:
            errors["desc"] = "Descrription should be at least 5 characters"
        return errors

class Book(models.Model):
    title = models.CharField(max_length = 45)
    desc = models.TextField()
    uploaded_by = models.ForeignKey(User, related_name ="books_uploaded",on_delete = models.CASCADE)
    liked_by = models.ManyToManyField(User, related_name ="books_liked")
    reated_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
    objects = BookManager()