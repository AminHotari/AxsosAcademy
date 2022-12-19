const express = require("express");
const app = express();

require("./srever/config/mongoose.config");

app.use(express.json(), express.urlencoded({extended: true}));

const AllJokesRoutes = require("./srever/routes/joke.routes");
 AllJokesRoutes(app);

 app.listen(8000, () => console.log("Welcome"));