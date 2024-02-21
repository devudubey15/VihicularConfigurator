import { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import './Contactus.css'; 

export default function Contactus() {
  const [getdetails, setDetails] = useState();
  const [msgBody, setMsgBody] = useState();

  const handleOnchange = (event) => {
    setDetails((eml) => ({ ...eml, [event.target.name]: event.target.value }));
    setMsgBody((msg) => ({ ...msg, [event.target.name]: event.target.value }));
    console.log(getdetails);
  };

  const sendEmail = (event) => {
    event.preventDefault();

    console.log(JSON.stringify(getdetails));

    fetch("http://localhost:8080/sendMail", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ ...getdetails, msgBody: msgBody.msgBody }),
    })
      .then((data) => {
        console.log(data);
        alert("Send Enquiry");
        // navigate('/home');
      })
      .catch((error) => {
        console.error("There was a problem with the fetch operation:", error);
      });
  };

  return (
    <div className="container-fluid entire_page_c">
      <div className="row justify-content-center">
        <div className="col-md-6 mt-5">
          <div className="login-container">
            <h2 className="login-heading">Contact Us</h2>
            <form onSubmit={sendEmail}>
              <div className="mb-3">
                <label htmlFor="name" className="form-label">
                  Name
                </label>
                <input
                  type="text"
                  name="name"
                  className="form-control"
                  placeholder="Enter your name"
                  required
                  onChange={handleOnchange}
                />
              </div>

              <div className="mb-3">
                <label htmlFor="email" className="form-label">
                  Email
                </label>
                <input
                  type="email"
                  name="useremail"
                  className="form-control"
                  placeholder="Enter your email"
                  required
                  onChange={handleOnchange}
                />
              </div>

              <div className="mb-3">
                <label htmlFor="query" className="form-label">
                  Query
                </label>
                <textarea
                  id="msgBody"
                  name="msgBody"
                  className="form-control"
                  placeholder="Enter your query"
                  required
                  onChange={handleOnchange}
                ></textarea>
              </div>

              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}