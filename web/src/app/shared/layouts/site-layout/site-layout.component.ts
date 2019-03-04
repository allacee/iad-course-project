import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-site-layout',
  templateUrl: './site-layout.component.html',
  styleUrls: ['./site-layout.component.css']
})
export class SiteLayoutComponent implements OnInit {

  currentNickname: string;

  links = [
    {url: '/profile-page', name: 'Мой профиль'},
    {url: '/message', name: 'Сообщения'},
    {url: '/games', name: 'Игры'},
    {url: '/somethelse1', name: 'Ещё что-то'}
  ]

  constructor(private auth: AuthService,
              private router: Router,
              private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.currentNickname = localStorage.getItem('curNickname');
  }

  logout(){
    this.httpClient.get('api/user/logout');
  }

}
