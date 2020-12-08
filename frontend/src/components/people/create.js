import React, { useState } from 'react'
import api from '../../services/api'
import { 
  Row,
  Col,
  Form,
} from 'react-bootstrap'
import 
  Button
 from 'react-bootstrap/Button';

function Create() {
  const [values, setValues] = useState({    
    name: '',
    gender: '',
    email: '',
    dateBirth: '',
    naturalness: '',
    nationality: '',
    cpf: ''
  });

  // const handleSave = (values) => {
  //   api.post('/login', values)

    
  // }
  async function handleSave(values) {
    const obj = await api.post('/v1/admin/people', {
      'date_birth': values.dateBirth,
      ...values
    });

    console.log(obj);
  }

  const handleChange = (event) => {
    setValues({
      ...values,
      [event.target.name]: event.target.value
    });
  };

  return (
    <Form onSubmit={event => {
        event.preventDefault();
        handleSave(values);
    }}>
      <Row>
        <Col xs="6">
          <Form.Label>Nome</Form.Label>
          <Form.Control type="name" 
            className="text-muted"
            name="name"
            value={values.name}
            onChange={handleChange}
            required
            placeholder="Digite seu nome de usuário" />         
        </Col>
        <Col xs="6">
          <Form.Label>Email</Form.Label>          
          <Form.Control type="email" 
            className="text-muted"
            name="email"
            value={values.email}
            onChange={handleChange}
            required
            placeholder="Digite seu email" />      
        </Col>        
      </Row>

      <Row>
        <Col xs="6">
          <Form.Label>Data de nascimento</Form.Label>
          <Form.Control type="dateBirth" 
            className="text-muted"
            name="dateBirth"
            value={values.dateBirth}
            onChange={handleChange}
            required
            placeholder="Digite sua data de nascimento" />      
        </Col>
        <Col xs="6">
          <Form.Label>Sexo</Form.Label>
          <Form.Control type="gender" 
            className="text-muted"
            name="gender"
            value={values.gender}
            onChange={handleChange}
            required
            placeholder="Digite sua data de nascimento" />  
        </Col>
      </Row>

      <Row>        
        <Col xs="4">
          <Form.Label>Natural</Form.Label>
          <Form.Control type="naturalness" 
            className="text-muted"
            name="naturalness"
            value={values.naturalness}
            onChange={handleChange}
            required
            placeholder="Digite sua naturalidade" />  
        </Col>
      
        <Col xs="4">
          <Form.Label>Nacionalidade</Form.Label>
          <Form.Control type="nationality" 
            className="text-muted"
            name="nationality"
            value={values.nationality}
            onChange={handleChange}
            required
            placeholder="Digite sua nacionalidade" />  
        </Col>

        <Col xs="4">
          <Form.Label>CPF</Form.Label>
          <Form.Control type="cpf" 
            className="text-muted"
            name="cpf"
            value={values.cpf}
            onChange={handleChange}
            required
            placeholder="Digite seu CPF" />  
        </Col>
      </Row>
      <br />
      <Button variant="primary" type="submit">
        Salvar
      </Button>
    </Form>  
  )
}

export default Create;
