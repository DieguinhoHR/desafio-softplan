import React, { createContext, useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

import api from './../services/api';

const AuthContext = createContext();

function AuthProvider({ children }) {
  const navigate = useNavigate();
  const [authenticated, setAuthenticated] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem('token');

    if (token) {
      api.defaults.headers.Authorization = `Bearer ${JSON.parse(token)}`;
      setAuthenticated(true);
    }
    setLoading(false);
  }, []);

  async function handleLogin(data) {
    const obj = await api.post('/login', data);
    const token = obj.data;

    localStorage.setItem('token', JSON.stringify(token));
    api.defaults.headers.Authorization = `Bearer ${token}`;
    setAuthenticated(true);
    navigate('/people/index', { replace: true });    
  }

  function handleLogout() {
    setAuthenticated(false);
    localStorage.removeItem('token');
    api.defaults.headers.Authorization = undefined;
    navigate('/', { replace: true });    
  }

  return (
    <AuthContext.Provider value={{ loading, authenticated, handleLogin, handleLogout }}>
      {children}
    </AuthContext.Provider>
  );
}

export default AuthProvider;

export { AuthContext };
