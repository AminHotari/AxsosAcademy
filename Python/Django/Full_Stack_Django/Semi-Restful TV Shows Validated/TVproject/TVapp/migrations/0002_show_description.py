# Generated by Django 4.1.1 on 2022-09-30 19:40

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('TVapp', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='show',
            name='description',
            field=models.TextField(default='No Description Yet'),
            preserve_default=False,
        ),
    ]
