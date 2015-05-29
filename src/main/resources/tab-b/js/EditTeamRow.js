jQuery.namespace("JIRA.Admin.Team.EditTeamRow");

JIRA.Admin.Team.EditTeamRow = AJS.RestfulTable.EditRow.extend({
    submit: function() {
        window.t = this;
        window.a = arguments;

        AJS.$.ajax({
            url: contextPath + '/rest/teams/1.0/teams.json',
            type: 'POST',
            contentType:"application/json; charset=utf-8",
            data: JSON.stringify({
                name: t.$el.get(0).firstChild.firstChild.value
            }),
            dataType: 'json'
        }).done(function(data) {
            console.warn(data);
            // JIRA.Admin.TeamTable.refresh()
            location.reload();
        });
        //AJS.RestfulTable.EditRow.prototype.submit.apply(this, ["test"]);
    },
    render: function() {

        var data = this.model.toJSON(),
            $el = this.$el;

        $el.html(JIRA.Templates.Team.editTeamRow({
            team: data
        }));

        return this;
    }
});
