from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('register', views.register),
    path('books', views.books),
    path('login', views.login),
    path('addbook', views.addbook),
    path('books/<int:id>', views.bookdetaile),
    path('addfav/<int:id>', views.addfav),
    path('delete/<int:id>', views.delete),
    path('update/<int:id>', views.update),
    path('unfav/<int:id>', views.unfav),
    path('addto/<int:id>', views.addto),
    path('logout', views.logout),
]
