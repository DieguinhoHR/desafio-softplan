import React, { useEffect, useState } from 'react';
import api from '../../services/api';
import { 
  Button,
  Table,
  Row,
  Col
} from 'react-bootstrap';
import { Link as RouterLink } from 'react-router-dom';
import Swal from 'sweetalert2';
import { useNavigate } from 'react-router-dom';

function Index() {
    const navigate = useNavigate();
    const [people, setPeople] = useState([])

    useEffect(() => {
      getAllPeople();       
    }, []);

    function getAllPeople() {
      (async () => {
        const { data } = await api.get('/v1/admin/people');
        setPeople(data.content);
      })();
    }

    function handleEdit(id) {
      return navigate(`/people/edit/${id}`, { replace: true });    
    }

    function handleDelete(id) {
      Swal.fire({
        title: 'Você deseja realmente remover este registro?',
        text: "Você não poderá reverter isso!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim, delete isso!'
      }).then((result) => {
        if (result.isConfirmed) {
          api
            .delete(`/v1/admin/people/${id}`, { data: { answer: 42 } })
            .then(() => {
              Swal.fire(
                'Deletado!',
                'Seu registro foi deletado com sucesso.',
                'success'
              )
              getAllPeople();
            })
            .catch(() => {
              Swal.fire(
                'Cancelado!',
                'Não foi possivel remover o registro.',
                'error'
              )
            });        
          }
      })
    }

    return <div>
      <h1>Listagem de pessoas</h1>
      <Row>
        <Col xs={6}>
          <RouterLink to={`/people/create`}>
            <Button size="sm">
              Adicionar pessoa
            </Button><br /><br />
          </RouterLink>
        </Col>
      </Row>
      <Table striped bordered hover>
          <thead>
              <tr>
                  <th>#</th>
                  <th>Nome</th>
                  <th>Email</th>
                  <th>Sexo</th>
                  <th>CPF</th>
                  <th>Ações</th>
              </tr>
          </thead>
          <tbody>
            {people.map(person => (
              <tr key={person.id}>
                  <td>{person.id}</td>
                  <td>{person.name}</td>
                  <td>{person.email}</td>
                  <td>{person.gender === 'MALE' ? 'Masculino' : 'Feminino' }</td>
                  <td>{person.cpf}</td>
                  <td colSpan="3">
                      <Button size="sm" onClick={() => handleEdit(person.id)}>
                        Atualizar
                      </Button>&nbsp;
                      <Button size="sm" variant="danger" onClick={() => handleDelete(person.id)}>
                        Remover    
                      </Button>
                  </td>
              </tr>             
            ))}                 
          </tbody>
      </Table>
    </div>
}

export default Index;
