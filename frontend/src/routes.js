import React, { useContext } from 'react';

import { Routes, Route, Navigate } from 'react-router-dom';

import { AuthContext } from './context/auth';

import Login from './components/auth/login';
import Index from './components/people/index';
import Create from './components/people/create';

function CustomRoute({ isPrivate, ...rest }) {
  const { loading, authenticated } = useContext(AuthContext);

  if (loading) {
    return <h1>Carregando...</h1>;
  }

  if (isPrivate && !authenticated) {
    return <Navigate to="/" />
  }
  return <Route {...rest} />;
}

export default function MainRoutes() {
  return (
    <Routes>
      <CustomRoute isPrivate path="people">
        <Route path="/index" element={<Index />} />        
        <Route path="/create" element={<Create />} />
        {/* <Route path="*" element={<Navigate to="/404" />} /> */}
      </CustomRoute>
      <Route path="/" element={<Login />} />
    </Routes>
  );
}
