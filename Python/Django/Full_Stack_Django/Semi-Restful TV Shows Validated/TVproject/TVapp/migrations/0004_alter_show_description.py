# Generated by Django 4.1.1 on 2022-10-02 16:53

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('TVapp', '0003_alter_show_description'),
    ]

    operations = [
        migrations.AlterField(
            model_name='show',
            name='description',
            field=models.TextField(),
        ),
    ]
