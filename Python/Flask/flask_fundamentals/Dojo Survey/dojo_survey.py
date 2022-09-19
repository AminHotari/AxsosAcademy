from flask import Flask, render_template, request
app = Flask(__name__)

@app.route("/")
def index():
    return render_template("dojo_survey.html")

@app.route("/result",methods=["post"])
def info():
    print(request.form)
    name1 = request.form["name"]
    location1 = request.form["location"]
    language1 = request.form["language"]
    comment1 = request.form["comment"]
    return render_template("results.html",name2=name1,location2=location1,language2=language1,comment2=comment1)

if __name__ == "__main__":
    app.run(debug=True)

