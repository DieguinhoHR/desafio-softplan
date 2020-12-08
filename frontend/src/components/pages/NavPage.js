import React, { useContext } from 'react';
import { 
  Nav,
  Navbar  
} from 'react-bootstrap';
import NavDropdown from 'react-bootstrap/NavDropdown'
import { AuthContext } from '../../context/auth';

function NavPage() {
  const { handleLogout, authenticated } = useContext(AuthContext);

  return (
    <Navbar bg="primary" variant="dark">
      <Navbar.Brand href="/people/index">Desafio Softplayer</Navbar.Brand>
      <Nav className="mr-auto">
        { authenticated && 
          <Nav.Link href="/people/index">Home</Nav.Link>
        }
        <Nav.Link href="#features">Cadastrar usuário</Nav.Link>
        { authenticated && 
          <Nav className="justify-content-end" activeKey="/home">
          <NavDropdown title="Opções" id="basic-nav-dropdown">
            <NavDropdown.Divider />
            <NavDropdown.Item onClick={() => handleLogout()}>Sair</NavDropdown.Item>
          </NavDropdown>
          </Nav>
        }        
      </Nav>       
    </Navbar>
  );
}

export default NavPage;