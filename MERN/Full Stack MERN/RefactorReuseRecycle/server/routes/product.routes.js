const ProductController = require('../controllers/product.controller');

// module.exports= function(app){}

module.exports = (app)=>{
    // app.get('/api', ProductController.index);
    app.post('/api/product', ProductController.createproduct);
    app.get('/api/product', ProductController.getAllProducts);
    app.get('/api/product/:id', ProductController.getProduct);
    app.delete('/api/product/:id', ProductController.deleteProduct);
    app.put('/api/product/:id', ProductController.updateProduct);
}