const {Product} = require('../models/product.model');

module.exports.createproduct = (request, response)=>{
    const {title, price, description}= request.body;
    Product.create({
        title,
        price,
        description,
    })
        .then(product => response.json(product))
        .catch(err => response.json(err));
}

module.exports.getAllProducts = (request,response)=>{
    Product.find({})
        .then(products=> response.json(products))
        .catch(err => response.json(err))
}

module.exports.getProduct = (request,response)=>{
    Product.findOne({_id: request.params.id})
        .then(product=> response.json(product))
        .catch(err=>response.json(err))
}

module.exports.deleteProduct = (request,response)=>{
    Product.deleteOne({_id: request.params.id})
        .then(deleteTheProduct =>response.json(deleteTheProduct))
        .catch(err => response.json(err))
}

module.exports.updateProduct = (request, response) => {
    Product.findOneAndUpdate({_id: request.params.id}, request.body, {new:true})
        .then(updateTheProduct => response.json(updateTheProduct))
        .catch(err => response.json(err))
}

// module.exports.index = (request, response) =>{
//     response.json({
//         message: "Hello World"
//     });
// }