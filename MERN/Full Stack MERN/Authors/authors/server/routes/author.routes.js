const AuthorController = require('../controllers/author.controller');

// module.exports= function(app){}

module.exports = (app)=>{
    // app.get('/api', ProductController.index);
    app.post('/api/author', AuthorController.createAuthor);
    app.get('/api/author', AuthorController.getAllAuthors);
    app.get('/api/author/:id', AuthorController.getAuthor);
    app.delete('/api/author/:id', AuthorController.deleteAuthor);
    app.put('/api/edit/author/:id', AuthorController.updateAuthor);
}