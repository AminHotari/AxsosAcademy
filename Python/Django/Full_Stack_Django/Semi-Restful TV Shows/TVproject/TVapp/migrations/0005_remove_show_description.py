# Generated by Django 4.1.1 on 2022-10-02 16:55

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('TVapp', '0004_alter_show_description'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='show',
            name='description',
        ),
    ]
