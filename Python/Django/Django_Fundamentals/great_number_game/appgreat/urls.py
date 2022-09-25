from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('random1', views.random1)
]