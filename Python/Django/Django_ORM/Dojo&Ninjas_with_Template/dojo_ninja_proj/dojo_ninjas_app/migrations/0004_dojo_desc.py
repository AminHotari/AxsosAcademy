# Generated by Django 4.1.1 on 2022-09-26 08:47

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('dojo_ninjas_app', '0003_remove_dojo_desc'),
    ]

    operations = [
        migrations.AddField(
            model_name='dojo',
            name='desc',
            field=models.TextField(default='old dojo', max_length=255),
            preserve_default=False,
        ),
    ]
