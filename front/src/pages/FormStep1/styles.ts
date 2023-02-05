import styled from "styled-components";

export const Container = styled.div`
p {
    font-size: 13px;
    color: #B8B8D4;
  }
 
  h1 {
      margin: 0;
      padding: 0;
      font-size: 22px;
  }

  hr {
      heigth: 1px;
      border: 0;
      background-color: #16195C;
      margin: 8px 0;
  }

  label {
      fonte-size: 13px;

      input {
          display: block;
          margin-top: 5px;
          box-sizing: border-box;
          width: 100%;
          padding: 15px 10px;
          border: 2px solid #25CD89;
          border-radius: 10px;
          color: #FFF;
          outline: 0;
          font-size: 12px;
          background-color: #02044A;
      }
  }
  button {
      background-color: #25CD89;
      color: #FFF;
      font-size: 14px;
      font-weigth: bold;
      padding: 20px 40px;
      border: 0;
      border-radius: 30px;
      cursor: pointer;
      margin-top: 10px 
  }
`;