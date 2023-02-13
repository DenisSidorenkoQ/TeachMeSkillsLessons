import * as React from 'react';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import {Box} from "@mui/material";
import {User} from "../model/UserState";
import sessionService from "../service/UserService";
import {useEffect, useState} from "react";

const UsersPage = () => {
    const columns: GridColDef[] = [
        { field: 'userId', headerName: 'ID', width: 400 },
        { field: 'login', headerName: 'Login', width: 400 }
    ];

    let ff: User[] = [];

    useEffect(() => {
        let userList: User[] = [];
        sessionService.getSession().then(users => users.forEach(user => userList.push(user)));
        console.log(userList);
        ff = userList;
    }, []);

    return (
        <Box sx={{ height: 800, width: '50%' }}>
            <DataGrid
                rows={ff}
                columns={columns}
                pageSize={10}
                rowsPerPageOptions={[5]}
                checkboxSelection
                disableSelectionOnClick
                experimentalFeatures={{ newEditingApi: true }}
            />
        </Box>
    );
};

export default UsersPage;
