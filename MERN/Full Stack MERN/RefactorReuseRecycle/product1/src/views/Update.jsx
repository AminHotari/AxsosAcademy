import { Link, navigate } from '@reach/router';
import axios from 'axios';
import React, { useEffect , useState } from 'react'
import DeleteButton from '../components/DeleteButton';
import ProductForm from '../components/ProductForm';


const Update = (props) => {
    const [product2,setProduct2] = useState({});
    const [loaded, setLoaded] = useState(false);

    useEffect(()=>{
        axios.get('http://localhost:8000/api/product/' +props.id)
            .then(res=>{
                setProduct2(res.data);
                setLoaded(true);
            })
            .catch(err=> console.log(err))
    },[])


    const updateProduct = (product2) =>{
        axios.put('http://localhost:8000/api/product/' +props.id, product2)
            .then(res=> navigate(`/${props.id}`))
            .catch(err=> console.log(err))
    }
  return (
    <div>
        {loaded && (
            <ProductForm
            theHead={"Update a Product"}
            created={updateProduct} 
            initialTitle={product2.title} 
            initialPrice={product2.price} 
            initialDescription={product2.description}
            theBtn={"Update"}/>
        )}
        <DeleteButton productId={product2._id} success={()=>navigate("/")}></DeleteButton>
        <Link to={"/"}>Back to Main</Link>
    </div>
  )
}

export default Update
