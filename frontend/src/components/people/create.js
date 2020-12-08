import React, { useState } from 'react'
import api from '../../services/api'
import { 
  Row,
  Col,
  Form,
  Card,
} from 'react-bootstrap'
import Button from 'react-bootstrap/Button';
import { cpfMask, dateOfBirthMask } from '../../utils/masks';

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

  async function handleSave(values) {
    console.log(values.gender)
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
    <div className="container">
      <Card>
        <Card.Header as="h5">Cadastro de pessoa</Card.Header>
        <Card.Body>
          <Form onSubmit={event => {
              event.preventDefault();
              handleSave(values);
          }}>
            <Form.Group>
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
            </Form.Group>

            <Form.Group >
              <Row>
                <Col xs="6">
                  <Form.Label>Data de nascimento</Form.Label>
                  <Form.Control type="dateBirth" 
                    className="text-muted"
                    name="dateBirth"
                    value={dateOfBirthMask(values.dateBirth)}
                    onChange={handleChange}
                    required
                    placeholder="Digite sua data de nascimento" />      
                </Col>
                <Col xs="6">
                  <Form.Label>Sexo</Form.Label>                  
                    <Form.Control 
                      as="select" 
                      name="gender"
                      id="gender"
                      defaultValue="Sexo"
                      onChange={handleChange}
                    >
                      <option value="0">Masculino</option>
                      <option value="1">Feminino</option>
                    </Form.Control>
                </Col>
              </Row>
            </Form.Group>

            <Form.Group> 
              <Row>   
                <Col xs="3">
                  <Form.Label>CPF</Form.Label>
                  <Form.Control type="cpf" 
                    className="text-muted"
                    name="cpf"
                    value={cpfMask(values.cpf)}
                    onChange={handleChange}
                    required
                    placeholder="Digite seu CPF" />  
                </Col>     
              
                <Col xs="3">
                  <Form.Label>Nacionalidade</Form.Label>
                  <Form.Control type="nationality" 
                    className="text-muted"
                    name="nationality"
                    value={values.nationality}
                    onChange={handleChange}
                    required
                    placeholder="Digite sua nacionalidade" />  
                </Col>

                <Col xs="6">                  
                  <Form.Label>Natural</Form.Label>
                  <Form.Control type="naturalness" 
                    className="text-muted"
                    name="naturalness"
                    value={values.naturalness}
                    onChange={handleChange}
                    required
                    placeholder="Digite sua naturalidade" />  
                </Col>
              </Row>
            </Form.Group>  
            <Button variant="primary" type="submit">
              Salvar
            </Button>
          </Form> 
        </Card.Body>
      </Card>
    </div> 
  )
}

export default Create;
