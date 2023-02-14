import React from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import UsersPage from "./pages/UsersPage";

function App() {
    return (
        <Routes>
            <Route path={'/users'} element={<UsersPage />} />
            <Route path={'*'} element={<Navigate to="/users" replace />} />
        </Routes>

    );
}

export default App;
