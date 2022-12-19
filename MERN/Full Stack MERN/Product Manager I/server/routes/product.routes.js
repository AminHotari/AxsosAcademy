const ProductController = require('../controllers/product.controller');

// module.exports= function(app){}

module.exports = (app)=>{
    // app.get('/api', ProductController.index);
    app.post('/api/product', ProductController.createproduct);
}