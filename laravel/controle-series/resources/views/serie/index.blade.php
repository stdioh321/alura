@extends("layouts.layout")

@section("title", "Series")
@section("b-title", "Series")
@section("content")
    <style>
        .remove-icon{
            position: relative;
            /*border: solid blue 1px;*/
            min-width: 20px;
            /*overflow: auto;*/
        }
        .remove-icon > *{
            color: red;
            position: absolute;
            top: 0px;
            right: 0;
            transform: translate(50%,-50%);
        }
        .remove-icon  i:hover{
            color: #1a202c;
            cursor: pointer;
        }
    </style>
    <div class="row">
        <div class="col-12">
            <a href="{{route("serie.create")}}" class="btn btn-primary">Adicionar</a>
        </div>
        <div class="col-12 my-1">
            <div class="row no-gutters  ">
                @if(isset($series))
                    @foreach($series as $serie)
                <div class="col-md-3 col-6 mt-1 p-1">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-subtitle">
                                <div class="d-flex justify-content-between">
                                    <div>
                                        {{$serie['id']}}
                                    </div>
                                    <div class="remove-icon">
                                        <form action="{{ url('/serie',['id'=>$serie['id']]) }}" method="post">
                                            <input type="hidden" name="_method" value="delete" />
                                            <label for="s{{$serie['id']}}" class="m-0 p-0">
                                                <i class="fa fa-trash-o " aria-hidden="true"></i>
                                            </label>
                                            <input type="submit" hidden id="s{{$serie['id']}}">

                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="card-text">{{$serie['nome']}}</div>
                        </div>
                    </div>
                </div>
                    @endforeach
                @endif
            </div>
        </div>
    </div>
@endsection
