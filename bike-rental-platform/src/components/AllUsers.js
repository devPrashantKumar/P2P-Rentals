import { useEffect } from "react";
import { all_users_url } from "../api-urls";
import axios from "axios";

function Allusers() {
    useEffect(()=>{
        document.title = "All Users";
        getallUsers();
        console.log(all_users_url)
    },[]);

    const getallUsers = () =>{
        axios.get(all_users_url).then(
            (response)=>{
                console.log(response);
            },
            (error)=>{
                console.log(error)
            }
        )
    };

  return (
    <div>
      <h3>All Users</h3>
      <h6>List of all Registered Users in Application</h6>
    </div>
  );
}

export default Allusers;
