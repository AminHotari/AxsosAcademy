# Generated by Django 4.1.1 on 2022-10-02 13:31

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('TVapp', '0002_show_description'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='description',
            field=models.TextField(default='Cool cool'),
        ),
    ]