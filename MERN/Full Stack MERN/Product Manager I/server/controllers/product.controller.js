const {Product} = require('../models/product.model');

module.exports.createproduct = (request, response)=>{
    const {title, price, desc}= request.body;
    Product.create({
        title : title,
        price : price,
        description: desc,
    })
        .then(product => response.json(product))
        .catch(err => response.json(err));
}
// module.exports.index = (request, response) =>{
//     response.json({
//         message: "Hello World"
//     });
// }