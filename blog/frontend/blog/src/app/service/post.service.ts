import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Post } from '../model/post';

const url = "http://localhost:3000/posts"

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http: HttpClient) {

  }

  getPosts(limit: number, page: number, nome?: string): Observable<Post[]> {
    let params = new HttpParams();
    params = params.set('_page', page);
    params = params.set('_limit', limit);

    if(nome){
      params = params.set('nome_like', nome);
    }

    return this.http.get<Post[]>(url, {params: params})
  }
  
  /* getPostsPorNome(nome: string): Observable<Post[]> {
    if(nome) {
      let params = new HttpParams();
      // configurando parâmetro para buscar por nome, ignorando maiúsculas e minúsculas
      params = params.set('nome_like', nome);
      return this.http.get<Post[]>(url, {params: params})
    } else {
      return this.getPosts();
    }
  } */

  addPost(post: Post): Observable<any> {
    return this.http.post(url, post);
  }
}
