import * as React from 'react';
import {DataGrid, GridColDef, GridValueGetterParams} from '@mui/x-data-grid';
import {Box} from "@mui/material";
import {User} from "../model/UserState";
import sessionService from "../service/UserService";
import {useEffect, useState} from "react";

const UsersPage = () => {
    const columns: GridColDef[] = [
        { field: 'userId', headerName: 'ID', width: 300 },
        { field: 'login', headerName: 'Login', width: 300 }
    ];

    const [subjectList, setSubjectList] = React.useState<User[]>([]);

    useEffect(() => {
        sessionService.getSession().then(users => setSubjectList(users));
    }, []);

    console.log(subjectList);

    return (
        <Box sx={{ height: 800, width: '50%' }}>
            <DataGrid
                getRowId={(row: any) =>  row.userId}
                rows={subjectList}
                columns={columns}
                pageSize={10}
                rowsPerPageOptions={[5]}
                disableSelectionOnClick
                experimentalFeatures={{ newEditingApi: true }}
            />
        </Box>
    );
};

export default UsersPage;
