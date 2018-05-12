import { Subject } from 'rxjs/Subject';

export class HttpClientResponseInterceptorService {
  needPrincipalRecheck = new Subject<null>();
  referer: string;
}
