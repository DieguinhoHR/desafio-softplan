import React, { useState, useEffect } from 'react'
import api from '../../services/api'
import { 
  Row,
  Col,
  Form,
  Card,
} from 'react-bootstrap'
import Button from 'react-bootstrap/Button';
import Swal from 'sweetalert2';
import { useParams } from 'react-router-dom';

function Create() {
  const [values, setValues] = useState({});
  const { id } = useParams();

  useEffect(() => {
    api.get(`/v1/admin/people/${id}`)
        .then(result => {
            setValues(result.data)
        })
  }, []);
  

  async function handleUpdate(values) {
    const obj = await api.put(`/v1/admin/people`, {
      'id': id,
      'date_birth': values.dateBirth,
      ...values
    });

    if (obj) {
      Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Registro atualizado com sucesso',
        showConfirmButton: false,
        timer: 1500
      })      
    }
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
        <Card.Header as="h5">Atualizar pessoa</Card.Header>
        <Card.Body>
          <Form onSubmit={event => {
              event.preventDefault();
              handleUpdate(values);
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
                    placeholder="Digite seu nome de usuário" />         
                </Col>
                <Col xs="6">
                  <Form.Label>Email</Form.Label>          
                  <Form.Control type="email" 
                    className="text-muted"
                    name="email"
                    value={values.email}
                    onChange={handleChange}
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
                    value={values.dateBirth}
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
                    value={values.cpf}
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
                    placeholder="Digite sua nacionalidade" />  
                </Col>

                <Col xs="6">                  
                  <Form.Label>Natural</Form.Label>
                  <Form.Control type="naturalness" 
                    className="text-muted"
                    name="naturalness"
                    value={values.naturalness}
                    onChange={handleChange}
                    placeholder="Digite sua naturalidade" />  
                </Col>
              </Row>
            </Form.Group>  
            <Button variant="primary" type="submit">
              Atualizar
            </Button>
          </Form> 
        </Card.Body>
      </Card>
    </div> 
  )
}

export default Create;
