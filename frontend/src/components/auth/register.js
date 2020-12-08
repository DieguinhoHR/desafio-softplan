import React, { useState, useContext } from 'react';
import {
  Form,
  Button,
} from 'react-bootstrap';
import { AuthContext } from '../../context/auth';
import api from '../../services/api'

const Login = () => {
  const { handleLogin } = useContext(AuthContext);

  const [values, setValues] = useState({
    username: '',
    password: '',
    name: '',
    admin: 1
  });  

  const handleChange = (event) => {
    setValues({
      ...values,
      [event.target.name]: event.target.value
    });
  };

  function handleSave() {
    api.post(`/v1/users`, {...values})
      .then(result => {
        //setValues(result.data)
        console.log('d');
      });
  }

  return (
    <div className="container">
      <Form onSubmit={event => {
        event.preventDefault();
        handleSave();
      }}>
        <Form.Group controlId="formBasicUsername">
            <Form.Label>Nome de usuário</Form.Label>
            <Form.Control type="username" placeholder="Digite seu nome de usuário" />
            <Form.Text 
              className="text-muted"
              name="username"
              value={values.username}
              onChange={handleChange}
              required
            >
                Digite seu usuário
            </Form.Text>
        </Form.Group>

        <Form.Group controlId="formBasicPassword">
            <Form.Label>Senha</Form.Label>
            <input
              type="password" 
              className="form-control" 
              id="password" 
              required
              placeholder="Digite sua senha" 
            />
        </Form.Group> 

        <Form.Group controlId="formBasicPassword">
            <Form.Label>Nome</Form.Label>
            <input
              type="name" 
              className="form-control" 
              id="name" 
              required
              placeholder="Digite seu nome" 
            />
        </Form.Group> 
        <Button variant="primary" type="submit">
            Salvar
        </Button>
      </Form>
    </div>   
  );
};

export default Login;
