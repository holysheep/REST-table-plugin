jQuery.namespace("JIRA.Admin.Team.EditTeamRow");

JIRA.Admin.Team.EditTeamRow = AJS.RestfulTable.EditRow.extend({
    submit: function() {
        var input = this.$el.get(0).firstChild.firstChild;

        AJS.$.ajax({
            url: contextPath + '/rest/teams/1.0/teams.json',
            type: 'POST',
            contentType:"application/json; charset=utf-8",
            data: JSON.stringify({
                name: input.value
            }),
            dataType: 'json'
        }).done(function(data) {
            JIRA.Admin.TeamTable.addRow(data);
            input.value = '';
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
