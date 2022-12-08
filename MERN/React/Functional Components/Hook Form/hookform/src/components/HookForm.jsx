import React, {useState} from 'react';

const HookForm = (props) => {
    const [firstname, setFirstname] = useState("");
    const [lastname, setLastname] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmpassword, setConfirmpassword] = useState("");

    const createUser = (e) => {
        e.preventDefault();
        const newUser = {firstname, lastname, email, password, confirmpassword};

    };


  return (
    <>
    <form onSubmit={createUser}>
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" onChange={(e) => setFirstname(e.target.value) } /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" onChange={(e) => setLastname(e.target.value) } /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" onChange={(e) => setEmail(e.target.value) } /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" onChange={(e) => setPassword(e.target.value) } /></td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" onChange={(e) => setConfirmpassword(e.target.value) } /></td>
            </tr>
        </table>
        <input type="submit" value="Create User" />    
    </form>
    <h3>Your Form Data</h3>
    <p>First Name: {firstname}</p>
    <p>Last Name: {lastname}</p>
    <p>Email: {email}</p>
    <p>Password: {password}</p>
    <p>Confirm Password: {confirmpassword}</p>
    </>
    
  );
}

export default HookForm