import React, { useState, useEffect } from "react";
import { useParams, useHistory } from "react-router-dom";
import { useQuery } from "react-query";

import { busca } from "../api/api";
import "../assets/css/post.css";
import Loading from "../components/Loading";

const Post = () => {
  let history = useHistory();
  const { id } = useParams();
  const [post, setPost] = useState({});
  const { isLoading, error, data } = useQuery("post", () => {
    let res = busca(`/posts/${id}`, () => {});
    return res;
  });
  // useEffect(() => {
  //   busca(`/posts/${id}`, setPost).catch(() => {
  //     // history.push('/404')
  //   });
  // }, [id]);
  if (error) {
    return (
      <div
        style={{
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          minHeight: "300px",
        }}
      >
        <div>
          <div>Oops. Something Went wrong.</div>
          <br />
          <div>{error?.message}</div>
        </div>
      </div>
    );
  }
  if (isLoading) {
    return (
      <div
        style={{
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
          minHeight: "300px",
        }}
      >
        <Loading>Carregando</Loading>
      </div>
    );
  }
  return (
    <main className="container flex flex--centro">
      <article className="cartao post">
        <h2 className="cartao__titulo">{data?.title}</h2>
        <p className="carta__texto">{data?.body}</p>
      </article>
    </main>
  );
};

export default Post;
