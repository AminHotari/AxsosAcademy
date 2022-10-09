from django.urls import path
from . import views


urlpatterns = [
    path('', views.index),
    path('shows', views.shows),
    path('shows/new', views.shows_new),
    path('create', views.create),
    path('shows/<int:id>', views.show_detaile),
    path('shows/<int:id>/edit', views.edit),
    path('update', views.update),
    path('shows/<int:id>/destroy', views.destroy),
]