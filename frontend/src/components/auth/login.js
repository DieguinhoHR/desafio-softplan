import React, { useState, useContext } from 'react';
import {
  Form,
  Button,
} from 'react-bootstrap';
import { AuthContext } from '../../context/auth'

const Login = () => {
  const { handleLogin } = useContext(AuthContext);

  const [values, setValues] = useState({
    username: 'bibop',
    password: '12345'
  });  

  const handleChange = (event) => {
    setValues({
      ...values,
      [event.target.name]: event.target.value
    });
  };

  return (
    <div className="container">
      <Form onSubmit={event => {
        event.preventDefault();
        handleLogin(values);
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
        <Button variant="primary" type="submit">
            Enviar
        </Button>
      </Form>
    </div>   
  );
};

export default Login;
