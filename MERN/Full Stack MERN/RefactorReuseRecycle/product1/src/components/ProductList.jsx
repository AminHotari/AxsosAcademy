import React from 'react'
import {Link , navigate} from '@reach/router'
// import axios from 'axios'
import DeleteButton from './DeleteButton'


const ProductList = (props) => {
  return (
    <div>
        <h2>All Products:</h2>
      {props.prod.map((product,index)=>{
        return(
            <p key={index}>
                <Link to = {"/" +product._id}>{product.title}</Link>|
                <Link to={`/${product._id}/edit`} >Edit</Link>
                <DeleteButton productId={product._id} success={()=>props.remove(product._id)}></DeleteButton>
            </p>
        )
      })}
    </div>
  )
}

export default ProductList
