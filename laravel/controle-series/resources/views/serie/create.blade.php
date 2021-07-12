@extends("layouts.layout")

@section("title", "Criar Serie")
@section("b-title", "Criar Serie")
@section("content")
    <div class="row">
        <div class="col-12">
            <form method="post" action="{{route('serie.store')}}">
                {!! csrf_field() !!}

                <div class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome" required minlength="3" />
                </div>

                <div class="form-group">
                    <button class="btn btn-primary" type="submit">Adicionar</button>
                </div>
            </form>
        </div>
    </div>
@endsection
