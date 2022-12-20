import React from 'react'
import {Link} from '@reach/router'
import axios from 'axios'


const ProductList = (props) => {

  return (
    <div>
        <h2>All Products:</h2>
      {props.prod.map((product,index)=>{
        return(
            <p key={index}>
                <Link to = {"/" +product._id}>{product.title}</Link>               
            </p>
        )
      })}
    </div>
  )
}

export default ProductList
