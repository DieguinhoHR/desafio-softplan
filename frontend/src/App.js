import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import Routes from './routes';
import { BrowserRouter as Router } from 'react-router-dom';
import { 
  Auth as AuthProvider,
} from './context';

import NavPage  from './components/pages/NavPage';

function App() {
  return (    
    <Router>
      <AuthProvider>
      <div className="App">
        <NavPage />
        <div className="container-fluid" style={{paddingTop: "20px"}}>
          <Routes />
        </div>
      </div>
      </AuthProvider>
    </Router>   
  );
}

export default App;
