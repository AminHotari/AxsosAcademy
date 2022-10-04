from django.db import models
from applogin.models import *

class Message(models.Model):
    message = models.TextField()
    users = models.ForeignKey(User, related_name= "messages",on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)

class Comment(models.Model):
    comment = models.TextField()
    users = models.ForeignKey(User, related_name= "commentsuser",on_delete = models.CASCADE)
    messages = models.ForeignKey(Message, related_name= "commentsmessage",on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add = True)
    updated_at = models.DateTimeField(auto_now = True)
