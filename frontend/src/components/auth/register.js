import React, { useState } from 'react';
import {
  Form,
  Button,
  Card,
} from 'react-bootstrap';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';
import Swal from 'sweetalert2';

const Register = () => {
  const navigate = useNavigate();
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

  async function handleSave() {
    const obj = await api.post('/v1/users', {
      ...values
    });

    if (obj) {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Registro inserido com sucesso',
        showConfirmButton: false,
        timer: 1500
      });
      return navigate('/', { replace: true });
    } else {
      Swal.fire({
        icon: 'info',
        title: 'Deu ruim',
        showConfirmButton: false,
        timer: 1500
      });
    }
  }

  return (
    <div className="container">
      <Card>
        <Card.Header as="h5">Cadastrar de usuário</Card.Header>
        <Card.Body>
          <Form onSubmit={event => {
            event.preventDefault();
            handleSave();
          }}>
            <Form.Group controlId="formBasicUsername">
              <Form.Label>Nome de usuário</Form.Label>
              <Form.Control type="username" 
                className="text-muted"
                name="username"
                value={values.username}
                required
                onChange={handleChange}
                placeholder="Digite seu nome de usuário" />
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
                <Form.Label>Senha</Form.Label>            
                <Form.Control type="password" 
                  className="text-muted"
                  name="password"
                  required
                  value={values.password}
                  onChange={handleChange}
                  placeholder="Digite sua senha" />     
            </Form.Group> 

            <Form.Group controlId="formBasicPassword">
              <Form.Label>Nome</Form.Label>
              <Form.Control type="name" 
                className="text-muted"
                name="name"
                required
                value={values.name}
                onChange={handleChange}
                placeholder="Digite seu nome" />      
            </Form.Group> 
            <Button variant="primary" type="submit">
                Salvar
            </Button>
          </Form>
        </Card.Body>
      </Card>
    </div>   
  );
};

export default Register;
