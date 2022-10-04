from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('/postmessage', views.postmessage),
    path('/addcomment', views.postcomment),
    path('/delete', views.delete),

]