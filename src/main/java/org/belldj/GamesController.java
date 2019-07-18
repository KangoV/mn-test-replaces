package org.belldj;

import java.util.List;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.reactivex.Observable;

@Controller("/games")
public class GamesController {

  private static final List<TGame> GAMES = List.of(
      new TGame("1", "Game1"),
      new TGame("1", "Game1"));

  public static class TGame {

    public String getId() {
      return id;
    }

    public void setId(final String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(final String name) {
      this.name = name;
    }

    private String id;
    private String name;

    public TGame(final String id, final String name) {
      this.id = id;
      this.name = name;
    }
  }

  @Secured("isAnonymous()")
  @Get("/")
  public List<TGame> list() {
    return GAMES;
  }

  @Secured("isAnonymous()")
  @Get("/obs")
  public Observable<TGame> observable() {
    return Observable.fromIterable(GAMES);
  }

  @Secured("isAnonymous()")
  @Get("/resp")
  public HttpResponse<List<TGame>> response() {
    return HttpResponse.<List<TGame>>ok().body(GAMES);
  }

}
