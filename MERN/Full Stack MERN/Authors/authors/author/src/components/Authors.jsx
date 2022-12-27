import React from 'react'
import {Link} from '@reach/router'
import { Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow} from '@material-ui/core';
import DeleteButton from './DeleteButton';


const Authors = (props) => {

  return (
    <div>
      <Link to={"/new/"}>Add an author</Link>
      <p>We have quotes by:</p>
      <TableContainer component={Paper} style={{margin:"0 auto",width:"40%"}}>
        <Table sx={{ minWidth: 650 }} aria-label="customized table" style={{border:"0.1rem solid black"}}>
          <TableHead style={{border:"0.1rem solid black"}}>
            <TableRow >
              <TableCell style={{color:"white",backgroundColor:"black"}}>Author</TableCell>
              <TableCell style={{color:"white",backgroundColor:"black"}}>Actions Avilables</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {props.auth.map((author,index)=>{
              return(
                <TableRow style={{border:"0.1rem solid black"}} key={index}>
                  <TableCell>{author.name}</TableCell>
                  <TableCell><button variant="contained"><Link to={`/edit/${author._id}`} key={index}>Edit</Link></button>|
                  <DeleteButton authorId={author._id} success={()=>{props.remove(author._id)}}>Delete</DeleteButton>
                  </TableCell>
                </TableRow>
              )
            })}
          </TableBody>
        </Table>
      </TableContainer> 
    </div>
  )
}

export default Authors
