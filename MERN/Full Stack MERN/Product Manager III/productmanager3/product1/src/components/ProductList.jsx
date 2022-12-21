import React from 'react'
import {Link} from '@reach/router'
import axios from 'axios'


const ProductList = (props) => {

  const deleteProduct = (productId)=>{
    axios.delete('http://localhost:8000/api/product/' +productId)
      .then(res => {
        props.remove(productId)
      })
      .catch(err => console.error(err));
  }
  return (
    <div>
        <h2>All Products:</h2>
      {props.prod.map((product,index)=>{
        return(
            <p key={index}>
                <Link to = {"/" +product._id}>{product.title}</Link>|
                <button onClick={(e)=>{deleteProduct(product._id)}}>Delete</button>
                
            </p>
        )
      })}
    </div>
  )
}

export default ProductList
